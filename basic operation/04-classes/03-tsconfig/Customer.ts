class Customers {

    private _firstName: string;
    private _lastName: string;

    constructor(theFirst: string, theLast: string) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }

    public get firstName(): string{
        return this._firstName;
    }
    public set firstName(value: string){
        this._firstName = value;
    }
    public get lastName(): string{
        return this._lastName;
    }
    public set lastName(value: string){
        this._lastName = value;
    }

    

}

let myCustomers = new Customers("Mark", "Eric");

//myCustomer.firstName = "Mark"; not use when have constructor setted.
//myCustomer.lastName = "Eric";

console.log(myCustomers.firstName);
console.log(myCustomers.lastName);
// to create tsconfig.json in terminal, using code: $ tsc --init;