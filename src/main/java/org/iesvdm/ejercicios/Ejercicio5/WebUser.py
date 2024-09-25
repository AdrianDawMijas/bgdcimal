# Definición de la clase UserState y OrderStatus como tipo Enum
from enum import Enum

class UserState(Enum):
    New = "New"
    Active = "Active"
    Blocked = "Blocked"
    Banned = "Banned"

class OrderStatus(Enum):
    New = "New"
    Hold = "Hold"
    Shipped = "Shipped"
    Delivered = "Delivered"
    Closed = "Closed"


# Definición de WebUser, Customer, Account, ShoppingCart, LineItem, Product, Order, Payment

class WebUser:
    def __init__(self, login_id: str, password: str, state: UserState):
        """Constructor para la clase WebUser"""
        self.login_id = login_id
        self.password = password
        self.state = state
        self.shopping_cart = None  # El carrito de compras puede no existir inicialmente

    def __str__(self):
        return f"WebUser(login={self.login_id}, state={self.state.value}, carrito={self.shopping_cart})"


class Customer:
    def __init__(self, id: str, address: str, phone: str, email: str):
        """Constructor para la clase Customer"""
        self.id = id
        self.address = address
        self.phone = phone
        self.email = email
        self.account = None  # El cliente puede no tener una cuenta asociada al principio


class Account:
    def __init__(self, id: str, billing_address: str, is_closed: bool, open_date: str, closed_date: str):
        """Constructor para la clase Account"""
        self.id = id
        self.billing_address = billing_address
        self.is_closed = is_closed
        self.open_date = open_date
        self.closed_date = closed_date
        self.orders = []  # Lista de pedidos asociados a la cuenta


class Product:
    def __init__(self, id: str, name: str, supplier: str):
        """Constructor para la clase Product"""
        self.id = id
        self.name = name
        self.supplier = supplier

    def __str__(self):
        return f"Producto(id={self.id}, nombre={self.name}, proveedor={self.supplier})"


class LineItem:
    def __init__(self, quantity: int, price: float, product: Product):
        """Constructor para la clase LineItem (representa un ítem en una orden)"""
        self.quantity = quantity
        self.price = price
        self.product = product

    def __str__(self):
        return f"Item(producto={self.product}, cantidad={self.quantity}, precio_unitario={self.price})"


class ShoppingCart:
    def __init__(self, created: str):
        """Constructor para la clase ShoppingCart"""
        self.created = created
        self.items = []  # Lista de productos en el carrito

    def add_item(self, line_item: LineItem):
        """Agrega un ítem al carrito"""
        self.items.append(line_item)

    def __str__(self):
        return f"Carrito creado el {self.created}, contiene: {self.items}"


class Payment:
    def __init__(self, id: str, paid_date: str, total: float, details: str):
        """Constructor para la clase Payment"""
        self.id = id
        self.paid_date = paid_date
        self.total = total
        self.details = details
        self.shipped = None  # Estado de envío del pago

    def __str__(self):
        return f"Pago(id={self.id}, fecha={self.paid_date}, total={self.total}, detalles={self.details})"


class Order:
    def __init__(self, number: str, ordered_date: str, ship_to: str, status: OrderStatus, total: float):
        """Constructor para la clase Order"""
        self.number = number
        self.ordered_date = ordered_date
        self.ship_to = ship_to
        self.status = status
        self.total = total
        self.cart = None  # Carrito asociado a la orden
        self.payments = []  # Lista de pagos realizados

    def add_payment(self, payment: Payment):
        """Agrega un pago a la orden"""
        self.payments.append(payment)

    def __str__(self):
        return (f"Pedido(numero={self.number}, fecha={self.ordered_date}, destinatario={self.ship_to}, "
                f"estado={self.status.value}, carrito={self.cart}, pagos={self.payments})")
