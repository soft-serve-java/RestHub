import {Injectable, NgModule, Inject} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Category} from '../models/category'
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AppService {
  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient) { }

  getCategories(): Observable<Array<Category>>{
    return this.http.get<Array<Category>>(this.categoryApi + 'category/all')
  }
}
