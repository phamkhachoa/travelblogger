import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TravelbloggerSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';
import { PostTempComponent } from './post-temp/post-temp.component';

@NgModule({
  imports: [TravelbloggerSharedModule, RouterModule.forChild(HOME_ROUTE)],
  declarations: [HomeComponent, PostTempComponent],
})
export class TravelbloggerHomeModule {}
