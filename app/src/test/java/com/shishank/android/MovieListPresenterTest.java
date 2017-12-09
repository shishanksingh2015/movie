package com.shishank.android;

import com.shishank.android.api.ApiService;
import com.shishank.android.models.response.DiscoverResponse;
import com.shishank.android.models.response.Result;
import com.shishank.android.movie.Contracts;
import com.shishank.android.movie.MovieListPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.mockito.Mockito.when;

/**
 * @author shishank
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = {"com.shishank.android.api.ApiModule",
        "com.shishank.android.api.ApiService", "com.shishank.android.BaseApplication"})
public class MovieListPresenterTest {

    @Mock
    private ApiService apiService;

    @Mock
    private Contracts.View movieView;

    @Mock
    private ApiComponent apiComponent;

    @BeforeClass
    public static void setupRxSchedulers() {
        Scheduler immediate = new Scheduler() {

            @Override
            public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
                return super.scheduleDirect(run, 0, unit);
            }

            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }
        };

        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> immediate);
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        Mockito.validateMockitoUsage();
    }

    @Test
    public void validDataReturned() {
        DiscoverResponse response = getResponse();

        BaseApplication mockApplication = new DebugBaseApplication();
        ((DebugBaseApplication)mockApplication).enableMockMode();
        PowerMockito.mockStatic(BaseApplication.class);
        Mockito.when(BaseApplication.getInstance()).thenReturn(mockApplication);

        PowerMockito.mockStatic(ApiService.class);

        when(apiService.getMoviesList(getRequest())).thenReturn(io.reactivex.Observable.just(response));

        Contracts.Presenter presenter = new MovieListPresenter(movieView);
        presenter.fetchMovies(1);

        Mockito.verify(movieView, Mockito.times(1)).populateData(response.getResults());
    }
    private Map<String, Object> getRequest() {
        Map<String, Object> map = new HashMap<>();
        map.put("api_key", Constants.API_KEY);
        return map;
    }

    public DiscoverResponse getResponse() {
        DiscoverResponse discoverResponse = new DiscoverResponse();
        List<Result> resultList = new ArrayList<>();
        discoverResponse.setResults(resultList);
        return discoverResponse;
    }
}