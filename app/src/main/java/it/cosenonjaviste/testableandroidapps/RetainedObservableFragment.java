package it.cosenonjaviste.testableandroidapps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import rx.functions.Action1;

public class RetainedObservableFragment<T> extends Fragment {

    private T object;
    private Action1<T> onDestroy;

    public RetainedObservableFragment() {
        setRetainInstance(true);
    }

    public T get() {
        return object;
    }

    public void init(T object, Action1<T> onDestroy) {
        this.object = object;
        this.onDestroy = onDestroy;
    }

    @Override public void onDestroy() {
        super.onDestroy();
        if (onDestroy != null) {
            onDestroy.call(object);
        }
    }

    public static <T> RetainedObservableFragment<T> getOrCreate(FragmentActivity activity, String tag) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        RetainedObservableFragment<T> fragment = (RetainedObservableFragment<T>) fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = new RetainedObservableFragment<>();
            fragmentManager.beginTransaction().add(fragment, tag).commit();
        }
        return fragment;
    }
}