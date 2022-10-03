export class Customers {

    constructor(private _firstName: string, private _lastName: string) {
        
    }
    public get firstName(): string{
        return this._firstName;
    }
    // ... getter and setter
}

let myCustomers = new Customers("Mark", "Eric");

