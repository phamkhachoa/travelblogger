import { Routes } from '@angular/router';

import { HomeComponent } from './home.component';
import { PostTempComponent } from 'app/home/post-temp/post-temp.component';

export const HOME_ROUTE: Routes = [
  {
    path: '',
    component: HomeComponent,
    data: {
      authorities: [],
      pageTitle: 'Welcome, Java Hipster!',
    }
  },
  {
    path: 'post',
    component: PostTempComponent,
    data: {
      authorities: [],
      pageTitle: 'Welcome, Java Hipster!',
    }
  },
];


