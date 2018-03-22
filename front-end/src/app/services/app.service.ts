import {Injectable, Inject} from '@angular/core';
import {HttpClient,} from '@angular/common/http';

import {Category} from '../models/category'

@Injectable()
export class AppService {
  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient) { }

  getCategories(): Promise<Category[]>{
    return this.http.get<Category[]>(this.categoryApi + 'category/all').toPromise()
  }

}
