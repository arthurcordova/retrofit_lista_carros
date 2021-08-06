package com.proway.retrofitapplication.model

data class User(
    val id: String,
    val email: String,
    val username: String,
    val password: String,
    val phone: String,
    val address: Address,
    val name: Name
) {


    fun listaUsuariosDaInstancia(): List<User> {
        return arrayListOf(
            User(
                id = "1",
                email = "arthur@gmail.com",
                username = "arthur.stapassoli",
                password = "123",
                phone = "1243434",
                address = Address("Blumenau", "rua 1", 2, "78678"),
                name = Name("arthur", "stapassoli")
            )

        )
    }


    companion object {


        fun listaUsuariosStatic(): List<User> {


            return arrayListOf(
                User(
                    id = "1",
                    email = "arthur@gmail.com",
                    username = "arthur.stapassoli",
                    password = "123",
                    phone = "1243434",
                    address = Address("Blumenau", "rua 1", 2, "78678"),
                    name = Name("arthur", "stapassoli")
                ),
                User(
                    id = "1",
                    email = "arthur@gmail.com",
                    username = "arthur.stapassoli",
                    password = "123",
                    phone = "1243434",
                    address = Address("Blumenau", "rua 1", 2, "78678"),
                    name = Name("arthur", "stapassoli")
                ),
                User(
                    id = "1",
                    email = "arthur@gmail.com",
                    username = "arthur.stapassoli",
                    password = "123",
                    phone = "1243434",
                    address = Address("Blumenau", "rua 1", 2, "78678"),
                    name = Name("arthur", "stapassoli")
                ),
                User(
                    id = "1",
                    email = "arthur@gmail.com",
                    username = "arthur.stapassoli",
                    password = "123",
                    phone = "1243434",
                    address = Address("Blumenau", "rua 1", 2, "78678"),
                    name = Name("arthur", "stapassoli")
                )
            )
        }

    }


}


data class Name(val firstname: String, val lastname: String)