package com.tisenres.urbaneyeapp.app.presentation.properties

class PropertiesPresenter(private val view: IPropertiesView): IPropertiesPresenter {
    
    override fun onButtonPressed(pos: Int) {
        view.navigateToInfoFragment()
    }
}