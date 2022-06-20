import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './users/login/login.component';
import { FormsModule } from '@angular/forms';
import { UserAccountComponent } from './users/user-account/user-account.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }