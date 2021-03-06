package it.cosenonjaviste.testableandroidapps.v5;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestModule.class)
public interface TestComponent {
    void inject(PostBatchTest test);
}
