import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }
  getAllDrivers() {
    return this.http.get<Driver[]>(`http://localhost:8080/persons/driver`);
  }

  getAllInsureds() {
    return this.http.get<Insured[]>(`http://localhost:8080/persons/insured`);
  }

  getAllMigrants() {
    return this.http.get<Migrant[]>(`http://localhost:8080/persons/migrant`);
  }

  getAllVoters() {
    return this.http.get<Voter[]>(`http://localhost:8080/persons/voter`);
  }



}

export class Migrant {
  constructor(
    public id: string,
    public firstname: string,
    public lastname: string,
    public age: number,
    public nationality: string,
  ) {}
}

export class Voter {
  constructor(
    public id: string,
    public firstname: string,
    public lastname: string,
    public age: number,
    public families: string,
  ) {}
}

export class Insured {
  constructor(
    public id: number,
    public firstname: string,
    public lastname: string,
    public age: string,
  ) {
  }
}

export class Driver {
  constructor(
    public licenceNumber: number,
    public firstname: string,
    public lastname: string,
    public age: number,
    public gender: string,
    public nationality: string,
    public licenceClass: string
  ) {}
}
