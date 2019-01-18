package gss.guru.iwork.ui;

public interface BaseView {

    /**
     * Базовый Presenter
     */
    interface Presenter<T extends RootView> {
        /**
         * Передает view в presenter.
         *
         * @param view the view
         */
        void bindView(T view);

        /**
         * Отписывается от запущенных задач, удаляет ссылку на view.
         */
        void unbindView();
    }

    /**
     * Базовый интерфейс для View
     */
    interface RootView {


    }

}
