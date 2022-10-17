package com.rosewhat.cleanarchitecture.di.dagger

import dagger.Component

@Component(modules = [AppModdule::class, DomainModdule::class, DataModdule::class],)
interface AppComponent {

}