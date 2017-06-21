import {Model} from "../model/model";
import {HttpService} from "./http.service";

export abstract class CrudService<T extends Model<ID>, ID> {

  public findAll(): Promise<T[]> {
    const url = `${this.getUrl()}`;
    return this.getHttpService().get(url)
      .toPromise()
      .then(response => response.json() as T[])
      .catch(this.handleError);
  }

  public findOne(id: ID): Promise<T> {
    const url = `${this.getUrl()}/${id}`;
    return this.getHttpService().get(url)
      .toPromise()
      .then(response => response.json() as T)
      .catch(this.handleError);
  }

  public save(t: T): Promise<T> {
    return this.getHttpService().post(this.getUrl(), t)
      .toPromise()
      .then(response => response.json() as T)
      .catch(this.handleError);
  }

  public remove(id: ID): Promise<void> {
    const url = `${this.getUrl()}/${id}`;
    return this.getHttpService().delete(url)
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  protected abstract getUrl(): string;

  protected abstract getHttpService(): HttpService;

  protected handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
