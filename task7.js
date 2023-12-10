class Client {
    #login;
    #email;
    constructor(login, email) {
        this.#login = login;
        this.#email = email;
    }
    get login() {
        return this.#login;
    }
    set login(login) {
        this.#login = login;
    }
    get email() {
        return this.#email;
    }
    set email(email) {
        this.#email = email;
    }
}