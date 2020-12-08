import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { VERSION } from 'app/app.constants';
import { AccountService } from 'app/core/auth/account.service';
import { LoginModalService } from 'app/core/login/login-modal.service';
import { LoginService } from 'app/core/login/login.service';
import { ProfileService } from 'app/layouts/profiles/profile.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MessageService } from 'primeng/api';
import { AuthServerProvider } from 'app/core/auth/auth-jwt.service';

@Component({
  selector: 'jhi-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['navbar.scss'],
  providers: [MessageService],
})
export class NavbarComponent implements OnInit {
  inProduction?: boolean;
  isNavbarCollapsed = true;
  swaggerEnabled?: boolean;
  version: string;
  credentials = { username: '', password: '' };
  display = false;
  closeResult = '';
  isLogin = false;
  user = {
    username: '',
    password: '',
    rememberMe: true,
  };

  constructor(
    private loginService: LoginService,
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    private profileService: ProfileService,
    private router: Router,
    private modalService: NgbModal,
    private messageService: MessageService,
    private authServerProvider: AuthServerProvider
  ) {
    this.version = VERSION ? (VERSION.toLowerCase().startsWith('v') ? VERSION : 'v' + VERSION) : '';
  }

  ngOnInit(): void {
    // this.ismodelShow = true;
    this.profileService.getProfileInfo().subscribe(profileInfo => {
      this.inProduction = profileInfo.inProduction;
      this.swaggerEnabled = profileInfo.swaggerEnabled;
    });
    const token = this.authServerProvider.getToken();
    if (token) {
      this.isLogin = true;
    }
  }

  collapseNavbar(): void {
    this.isNavbarCollapsed = true;
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  // login(): void {
  //   this.loginModalService.open();
  // }

  logout(): void {
    this.loginService.logout();
    this.isLogin = false;
  }

  toggleNavbar(): void {
    this.isNavbarCollapsed = !this.isNavbarCollapsed;
  }

  getImageUrl(): string {
    return this.isAuthenticated() ? this.accountService.getImageUrl() : '';
  }

  showDialog(): void {
    this.display = true;
  }

  login(): any {
    console.log(this.user);
    this.loginService.login(this.user).subscribe(
      result => {
        console.log('result');
        console.log(result);
        this.isLogin = true;
        this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Message Content' });
      },
      () => {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Message Content' });
      }
    );

    this.display = false;
  }

  showSuccess(): void {
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Message Content' });
  }
}
