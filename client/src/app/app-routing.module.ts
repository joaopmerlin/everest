import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./component/login.component";
import {LoginService} from "./service/login.service";
import {HomeComponent} from "./component/home.component";
import {FrameComponent} from "./component/frame.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},

  {path: '', canActivate: [LoginService], children: [
    {path: '', children: [
      {path: 'home', component: HomeComponent},
      {path: 'frame', component: FrameComponent}
    ]}
  ]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
