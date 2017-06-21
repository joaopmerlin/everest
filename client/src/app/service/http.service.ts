import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class HttpService {

  constructor(private http: Http) {
  }

  options(): RequestOptions {
    let token = localStorage.getItem("access_token");
    if (token) {
      return new RequestOptions({
        headers: new Headers({
          'Authorization': 'bearer ' + localStorage.getItem("access_token")
        })
      });
    }
    return null;
  }

  get(url: string): Observable<Response> {
    return this.http.get(url, this.options());
  }

  post(url: string, body: any): Observable<Response> {
    return this.http.post(url, body, this.options());
  }

  delete(url: string): Observable<Response> {
    return this.http.delete(url, this.options());
  }
}
