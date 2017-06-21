import {Component} from "@angular/core";
import {LoginService} from "../service/login.service";
import {Router} from "@angular/router";
import {User} from "../model/user";
import {MdSnackBar} from "@angular/material";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-login',
  templateUrl: '../view/login.component.html',
  styleUrls: ['../style/login.component.css']
})
export class LoginComponent {

  user: User = new User();
  createAccount: boolean = false;

  constructor(private router: Router,
              private snackBar: MdSnackBar,
              private userService: UserService,
              private loginService: LoginService) {
  }

  login(user: User) {
    this.loginService.login(user.email, user.password).then(() => {
      this.router.navigate(['/home']);
    }).catch(() => {
      this.snackBar.open('Email or password is invalid!', null, {duration: 2000});
    });
  }

  create(user: User) {
    this.userService.save(user).then(e => {
      this.snackBar.open('User has been created', null, {duration: 2000});
      this.login(user);
    }).catch(e => {
      this.snackBar.open(e.json().message, null, {duration: 2000});
    });
  }

}
