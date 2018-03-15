import {Role} from "./role";

export class User {
  private id: number;
  private email: string;
  private password: string;
  private name: string;
  private confirmationtoken: boolean;
  private enabled: boolean;
  private roles: Role[];
  private avatar: string;


  constructor(id: number, email: string, password: string, name: string, confirmationtoken: boolean, enabled: boolean, roles: Role[], avatar: string) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
    this.confirmationtoken = confirmationtoken;
    this.enabled = enabled;
    this.roles = roles;
    this.avatar = avatar;
  }
}
