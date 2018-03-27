import {Injectable, NgModule, Inject} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse, HttpParams} from '@angular/common/http';


import {Dish} from '../models/dish'
@Injectable()
export class MenuService {
  constructor(@Inject('API_URL') private rootApi: string, private http:HttpClient) { }

  getDishesByCategory(category: string, page: number): Promise<HttpResponse<Dish[]>> {
    let params = new HttpParams().set('page', String(page));
    return this.http.get<Dish[]>(this.rootApi + 'dish/by' + category, {params: params, observe: 'response'}).toPromise();
  }

  getDishById(dishId: number) : Promise<Dish>{
    return this.http.get<Dish>(this.rootApi + "dish/" + dishId).toPromise();
  }

  getDishPopulars(dishId: number) : Promise<Dish[]>{
    return this.http.get<Dish[]>(this.rootApi + "dish/" + dishId + "/populars").toPromise();
  }

  getDishByName(name: string): Promise<Dish[]> {
    const params = new HttpParams().set('search', name);
    return this.http.get<Dish[]>(this.rootApi + "dish/", {params: params}).toPromise();
  }

}
