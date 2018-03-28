import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Dish} from "../models/dish";



@Injectable()
export class AdminDishService {

  constructor(@Inject('API_URL') private dishApi: string, private http:HttpClient){}

  getDish(): Promise<Dish[]>{
    return this.http.get<Dish[]>(this.dishApi + "admin/dish/all").toPromise();
}

  deleteDish(id: number): Promise<any>{
      return this.http
        .delete(this.dishApi + "admin/dish/" + id )
        .toPromise()
        .then()
  }
}
