import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../models/category";
import {User} from "../models/user";
import {Dish} from "../models/dish";

@Injectable()
export class AdminCategoryService {

  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient){}

  getCategory(): Promise<Category[]>{
    return this.http.get<Category[]>(this.categoryApi + "admin/category/all").toPromise();
  }

  deleteCategory(id:number):Promise<any>{
    return this.http
      .delete(this.categoryApi + "admin/category/" + id)
      .toPromise()
  }

  addCategory(name: String): Promise<any>{
    return this.http
      .post(this.categoryApi + 'admin/category/add', {name})
      .toPromise()
  }

  editCategory(category: Category): Promise<any>{
    return this.http
      .post(this.categoryApi + "admin/category/add/", category)
      .toPromise()
  }

  getCategoryById(id: number): Promise<Category>{
    return this.http
      .get<Category>(this.categoryApi + "admin/category/" + id)
      .toPromise()
  }
}
