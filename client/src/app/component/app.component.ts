import {Component, OnInit} from "@angular/core";
import {LoginService} from "../service/login.service";
import {User} from "../model/user";

@Component({
  selector: 'app-root',
  templateUrl: '../view/app.component.html'
})
export class AppComponent implements OnInit {

  user: User = new User();

  constructor(private loginService: LoginService) {
  }

  ngOnInit(): void {
    this.loginService.setUser();
    this.loginService.getUser().subscribe(e => this.user = e);
  }
}
