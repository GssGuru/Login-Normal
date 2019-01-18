package gss.guru.iwork.ui.main;


import gss.guru.iwork.ui.BaseView;

public interface MainPresenterView {

    /**
     * Экран Открытия смены.
     */
    interface View extends BaseView.RootView {
        /**
         * Открыть окно инкасации
         *
         * @param value максимальная сумма инкасации
         */
        void setData(String value);

        void setError(String value);
    }

    /**
     * Presenter для экрана Открытия смены.
     */
    interface Presenter extends BaseView.Presenter<View> {

        /**
         * Выполнить сверку отчетов и распечатать (если есть принтер)
         */
        void doSomeInMresenter();

        /**
         * Событие создания View
         */
        void onViewCreated();
    }

}
