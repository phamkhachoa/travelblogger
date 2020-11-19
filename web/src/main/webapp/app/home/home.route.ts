import { Routes } from '@angular/router';

import { HomeComponent } from './home.component';
import { TestComponent } from 'app/home/test/test.component';

export const HOME_ROUTE: Routes = [
  {
    path: '',
    component: HomeComponent,
    data: {
      authorities: [],
      pageTitle: 'Welcome, Java Hipster!',
    },
    children: [
      { path: 'test', component: TestComponent }
    ],
  },
];


