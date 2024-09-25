from WebUser import ShoppingCart, UserState, WebUser, Customer, Payment, Account, LineItem, Order, Product, OrderStatus

# Creación de usuarios
cesar = WebUser("1001", "securePass123", UserState.Banned)
alan = WebUser("1002", "passWord321", UserState.Active)
adrian = WebUser("1003", "blockMe99", UserState.Blocked)

# Creación de clientes
cesarCustom = Customer("1001", "1234 Elm St", "555-1234", "cesar@example.com")
alanCustom = Customer("1002", "4321 Oak Ave", "555-5678", "alan@example.com")
adrianCustom = Customer("1003", "9876 Pine Blvd", "555-8765", "adrian@example.com")

# Creación de cuentas
cesarAccount = Account("1001", "Premium", True, "2024-01-01", "2025-01-01")
alanAccount = Account("1002", "Standard", False, "2023-05-15", "2024-05-15")
adriansitoAccount = Account("1003", "Premium", True, "2024-03-01", "2025-03-01")

# Creación de productos
manzana = Product("5001", "Manzana", "Fruta fresca de primera calidad")
pera = Product("5002", "Pera", "Pera dulce y jugosa")
banana = Product("5003", "Banana", "Bananas orgánicas de comercio justo")

# Creación de líneas de pedido (cantidad, precio unitario, producto)
linea1 = LineItem(3, 1.50, manzana)   # 3 manzanas a 1.50€ cada una
linea2 = LineItem(2, 2.00, pera)      # 2 peras a 2.00€ cada una
linea3 = LineItem(5, 0.80, banana)    # 5 bananas a 0.80€ cada una

# Carrito de compras para César
cesarKart = ShoppingCart("2024-09-25")
cesarKart.add_item(linea1)
cesarKart.add_item(linea2)
cesarKart.add_item(linea3)

# Creación del pedido
pedido = Order("3001", "2024-09-25", "César Martínez", OrderStatus.Delivered, 18.40)
pedido.cart = cesarKart

# Creación del pago
pago = Payment("5001", "2024-09-25", 18.40, "Tarjeta de crédito")
pedido.add_item(pago)

# Imprimir los detalles del pedido
print(pedido)
