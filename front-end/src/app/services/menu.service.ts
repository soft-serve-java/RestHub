import {Injectable, NgModule, Inject} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse, HttpParams} from '@angular/common/http';
import {Observable} from "rxjs/Rx";


import {Dish} from '../models/dish'
@Injectable()
export class MenuService {
  private string;

  constructor(@Inject('API_URL') private rootApi: string, private http:HttpClient) { }

  getDishesByCategory(category: string, page: number): Observable<HttpResponse<Dish[]>> {
    const params = new HttpParams()
    .set('page', String(page));
    return this.http.get<Dish[]>(this.rootApi + 'dish/by' + category, {params: params, observe: 'response'})
  }

}
