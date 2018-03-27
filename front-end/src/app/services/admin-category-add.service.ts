import {Inject, Injectable} from '@angular/core';
import {Category} from "../models/category";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AdminCategoryAddService {

  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient){}

  getCategory(): Promise<Category[]>{
    return this.http.get<Category[]>(this.categoryApi + "admin/category/add").toPromise();
  }


  addCategory(categoryName: String): Promise<any>{
    return this.http
      .post(this.categoryApi + 'admin/category/add', {name: categoryName})
      .toPromise()
      .then()
  }


  editCategory(id:number, categoryName: string): Promise<any>{
    return this.http
      .post(this.categoryApi + "admin/category/" + id, {category: new Category(id, categoryName)})
      .toPromise()
      .then(res =>  console.log(res))
  }
}
