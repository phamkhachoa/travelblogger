import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { TravelbloggerSharedModule } from 'app/shared/shared.module';
import { TravelbloggerCoreModule } from 'app/core/core.module';
import { TravelbloggerAppRoutingModule } from './app-routing.module';
import { TravelbloggerHomeModule } from './home/home.module';
import { TravelbloggerEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { NavbarCustormComponent } from './layouts/navbar-custorm/navbar-custorm.component';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { CheckboxModule } from 'primeng/checkbox';

@NgModule({
  imports: [
    BrowserModule,
    TravelbloggerSharedModule,
    TravelbloggerCoreModule,
    TravelbloggerHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    TravelbloggerEntityModule,
    TravelbloggerAppRoutingModule,
    DialogModule,
    BrowserAnimationsModule,
    ButtonModule,
    ToastModule,
    CheckboxModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent, NavbarCustormComponent],
  bootstrap: [MainComponent],
})
export class TravelbloggerAppModule {}
