package tech.thdev.app.base.presenter

/**
 * Created by Tae-hwan on 7/21/16.
 */
interface BasePresenter<in VIEW : BaseView<*>> {

    /**
     * View Attach.
     */
    fun attachView(view: VIEW)

    /**
     * View detach
     */
    fun detachView()
}