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
      .delete(this.categoryApi + "admin/category/" + id )
      .toPromise()
      .then()
  }


}
