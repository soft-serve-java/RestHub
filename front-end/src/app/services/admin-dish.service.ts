import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Dish} from "../models/dish";
import {Category} from "../models/category";

@Injectable()
export class AdminDishService {

  constructor(@Inject('API_URL') private dishApi: string, private http:HttpClient){}

  getDish(): Promise<Dish[]>{
    return this.http.get<Dish[]>(this.dishApi + "admin/dish/all").toPromise();
}

  deleteDish(id: number): Promise<any>{
      return this.http
        .delete(this.dishApi + "admin/dish/delete/" + id )
        .toPromise()
        .then()
  }


  // Добавить category: Category,
  addDish(dish): Promise<any>{
    return this.http
      .post(this.dishApi + "admin/dish/add", {dish: new Dish ()})
      .toPromise()
      .then()
  }

  editDish(dish): Promise<any>{
    return this.http
      .post(this.dishApi + "admin/dish/add", {dish: new Dish ()})
      .toPromise()
      .then(res =>  console.log(res))
  }
}
