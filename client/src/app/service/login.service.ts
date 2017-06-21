import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {environment} from "../../environments/environment";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {User} from "../model/user";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {HttpService} from "./http.service";

@Injectable()
export class LoginService implements CanActivate {

  private subjectUser = new Subject<User>();

  constructor(private router: Router,
              private httpA: Http,
              private http: HttpService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    let check = localStorage.getItem('access_token') != null;
    if (!check) {
      this.router.navigate(['/login']);
    }
    return check;
  }

  login(email, password): Promise<void> {
    let params = new URLSearchParams();
    params.append('username', email);
    params.append('password', password);
    params.append('grant_type', 'password');

    let headers = new Headers({
      'Content-type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic YXBwOmFwcA=='
    });
    let options = new RequestOptions({headers: headers});

    const url = `${environment.proxy}/oauth/token`;
    return this.httpA.post(url, params.toString(), options)
      .toPromise()
      .then(e => {
        this.saveToken(e.json());
        this.setUser();
      })
      .catch(this.handleError);
  }

  saveToken(token) {
    localStorage.setItem('access_token', token.access_token);
  }

  setUser() {
    const url = `${environment.proxy}/user/userLogged`;
    this.http.get(url)
      .toPromise()
      .then(response => this.subjectUser.next(response.json() as User));
  }

  getUser(): Observable<User> {
    return this.subjectUser.asObservable();
  }

  logout() {
    localStorage.removeItem('access_token');
    this.router.navigate(['/login']);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
