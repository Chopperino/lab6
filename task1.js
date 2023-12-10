let objects = [];
function createProduct(obj, callback){
    obj.id = objects.length + 1;
    callback(obj);
}

function logProduct(product){
    console.log(product);
}
function logTotalPrice(product){
    product.hasOwnProperty("price") ? console.log(product.price) : console.log(`${product.name} does not have price`);
}

createProduct({name: 'trenbolone', price: 30}, logTotalPrice);