const medicines = {
    Analgin: new Date('2022-05-01'),
    Noshpa: new Date('2025-07-02'),
    Alphaholin: new Date('2024-12-21'),
    Aspirine: new Date('2022-08-15'),
    Asparcame: new Date('2024-04-18'),
};
function getAvailableMedicines(medicines){
    const arrayOfEntries = Object.entries(medicines);
    arrayOfEntries.sort((a, b) => a[1] - b[1]);
    let newMedicines = [];
    for (const [key, value] of arrayOfEntries) {
        if(value > new Date()){
            newMedicines.push(key);
        }
    }
    return newMedicines;
}

console.log(getAvailableMedicines(medicines));