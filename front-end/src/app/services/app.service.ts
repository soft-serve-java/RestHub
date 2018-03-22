import {Injectable, Inject} from '@angular/core';
import {HttpClient,} from '@angular/common/http';

import {Category} from '../models/category'

@Injectable()
export class AppService {
  constructor(@Inject('API_URL') private api: string, private http:HttpClient) { }

  doPOSTonCallWaiter(tableNumber:number) {
    return this.http.post(this.api + '/callWaiterClient', tableNumber);
  }
  getCategories(): Promise<Category[]>{
    return this.http.get<Category[]>(this.categoryApi + 'category/all').toPromise()
  }

}
