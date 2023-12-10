function fruitsDiscount(fruits) {
    return fruits.map((fruit, index) => {
        const {name, price} = fruit; // const name = fruit.name; const price = fruit.price;
        const newPrice = price * 0.8;
        const newId = index + 1;
        return {id: newId, name, price: newPrice};
    });
}

const fruits = [
    { name: "apple", price: 200 },
    { name: "orange", price: 300 },
    { name: "grapes", price: 750 },
];

console.log(fruitsDiscount(fruits));