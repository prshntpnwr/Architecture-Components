package com.example.prashant.databinding.di;

import android.app.Application;

import com.example.prashant.databinding.di.module.ActivityModule;
import com.example.prashant.databinding.di.module.AppModule;
import com.example.prashant.databinding.di.module.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        public Builder application(Application application);

        public AppComponent build();
    }

    public void inject(App app);
}
