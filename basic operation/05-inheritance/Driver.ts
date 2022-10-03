import { Shape } from './Shape';
import { Circle} from './Circle';
import { Rectangle } from './Rectangle';
import { collapseTextChangeRangesAcrossMultipleVersions } from 'typescript';

/*
let myShape = new Shape(10, 15);
console.log(myShape.getInfo());

let myCircle = new Circle(5, 10, 20);
console.log(myCircle.getInfo());

let myRec = new Rectangle(0, 0, 3, 7);
console.log(myRec.getInfo());
*/

// Array work
let myShape = new Shape(10, 15);
let myCircle = new Circle(5, 10, 20);
let myRec = new Rectangle(0, 0, 3, 7);
// declare the array of shapes..
let theShape: Shape[] = [];
// add shapes to array..
theShape.push(myShape);
theShape.push(myCircle);
theShape.push(myRec);

for (let thempShape of theShape) {
    console.log(thempShape.getInfo());
    console.log();
}

// remeber to add the tsconfig file from terminal