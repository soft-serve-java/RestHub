import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../models/category";

@Injectable()
export class AdminCategoryService {

  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient){}

  getCategory(): Promise<Category[]>{
    return this.http.get<Category[]>(this.categoryApi + "admin/category/all").toPromise();
  }

  deleteCategory(id:number):Promise<any>{
    return this.http
      .delete(this.categoryApi + "admin/category/" + id +"/delete")
      .toPromise()
      .then()
  }

  editCategory(id:number, categoryName: String):Promise<any>{
    return this.http
      .put(this.categoryApi + "admin/category/" + id +"/edit", {name: categoryName})
      .toPromise()
  }

  /*  changeColor(car: any, color: string) {
      car.color = color;
      return this.http.put(`http://localhost:3000/cars/${car.id}`, car)
        .map((response: Response) => response.json());
    }

    addCategory(categoryName: String): Promise<any>{
      return this.http
        .post(this.categoryApi + 'admin/category/add', {name: categoryName})
        .toPromise()
        .then()
    }*/
}
