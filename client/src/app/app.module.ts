import {
  MdButtonModule,
  MdCardModule,
  MdIconModule,
  MdInputModule,
  MdMenuModule,
  MdSidenavModule,
  MdSnackBarModule,
  MdToolbarModule
} from "@angular/material";
import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./component/app.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToolbarComponent} from "./component/toolbar.component";
import {AppRoutingModule} from "./app-routing.module";
import {HomeComponent} from "./component/home.component";
import {LoginComponent} from "./component/login.component";
import {LoginService} from "./service/login.service";
import {UserService} from "./service/user.service";
import {HttpService} from "./service/http.service";
import {FrameComponent} from "./component/frame.component";

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    HomeComponent,
    LoginComponent,
    FrameComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MdButtonModule,
    MdToolbarModule,
    MdCardModule,
    MdInputModule,
    MdSnackBarModule,
    MdSidenavModule,
    MdIconModule,
    MdMenuModule
  ],
  providers: [
    HttpService,
    LoginService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
