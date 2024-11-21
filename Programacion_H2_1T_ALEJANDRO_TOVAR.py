import random

# Diccionario para guardar los datos de los clientes (correo como clave única)
clientes = {}

# Lista con los productos de Samsung disponibles en la tienda
productos = [
    {"id": 1, "nombre": "Samsung Galaxy S23", "precio": 999.99},
    {"id": 2, "nombre": "Samsung Galaxy Tab S9", "precio": 799.99},
    {"id": 3, "nombre": "Samsung Galaxy Watch 6", "precio": 399.99},
    {"id": 4, "nombre": "Samsung Galaxy Buds Pro 2", "precio": 199.99},
    {"id": 5, "nombre": "Samsung Smart Monitor M8", "precio": 699.99},
]

# Diccionario para guardar los pedidos (id del pedido como clave)
pedidos = {}

# Función para registrar un cliente
def registrar_cliente():
    print("\n--- Registro de Cliente ---")
    nombre = input("Nombre: ")  # Pedimos el nombre del cliente
    correo = input("Correo electrónico: ")  # Pedimos el correo, será único
    telefono = input("Teléfono: ")  # Pedimos el teléfono del cliente
    
    if correo in clientes:  # Comprobamos si el correo ya está registrado
        print("Error: El correo ya está registrado.")
    else:
        # Guardamos los datos del cliente en el diccionario
        clientes[correo] = {"nombre": nombre, "telefono": telefono}
        print(f"Cliente {nombre} registrado con éxito.")  # Confirmamos el registro

# Función para mostrar todos los clientes registrados
def ver_clientes():
    print("\n--- Clientes Registrados ---")
    if not clientes:  # Comprobamos si no hay clientes
        print("No hay clientes registrados.")
    else:
        # Recorremos el diccionario y mostramos los datos de cada cliente
        for correo, datos in clientes.items():
            print(f"Correo: {correo}, Nombre: {datos['nombre']}, Teléfono: {datos['telefono']}")

# Función para buscar un cliente por su correo
def buscar_cliente():
    print("\n--- Buscar Cliente ---")
    correo = input("Introduce el correo del cliente: ")  # Pedimos el correo a buscar
    if correo in clientes:  # Si el cliente existe, mostramos sus datos
        datos = clientes[correo]
        print(f"Cliente encontrado: Nombre: {datos['nombre']}, Teléfono: {datos['telefono']}")
    else:
        print("Cliente no encontrado.")  # Si no existe, mostramos un mensaje de error

# Función para realizar una compra
def realizar_compra():
    print("\n--- Realizar Compra ---")
    correo = input("Correo del cliente: ")  # Pedimos el correo del cliente
    if correo not in clientes:  # Comprobamos si el cliente no existe
        print("Error: Cliente no encontrado.")
        return  # Salimos de la función
    
    # Mostramos los productos disponibles
    print("Productos Samsung disponibles:")
    for producto in productos:
        print(f"{producto['id']}: {producto['nombre']} - {producto['precio']} €")

    # Pedimos los IDs de los productos que el cliente quiere comprar
    ids_productos = input("Introduce los IDs de los productos a comprar (separados por comas): ")
    ids_productos = ids_productos.split(",")  # Dividimos los IDs en una lista
    productos_seleccionados = []

    # Buscamos cada producto por su ID
    for id_producto in ids_productos:
        try:
            id_producto = int(id_producto)  # Convertimos el ID a número
            # Buscamos el producto en la lista
            producto = next(p for p in productos if p["id"] == id_producto)
            productos_seleccionados.append(producto)  # Lo añadimos a la lista de seleccionados
        except (ValueError, StopIteration):  # Si el ID no es válido, lo ignoramos
            print(f"Producto con ID {id_producto} no encontrado. Ignorando.")
    
    if productos_seleccionados:  # Si se seleccionaron productos válidos
        # Generamos un número de pedido aleatorio entre 1000 y 9999
        id_pedido = str(random.randint(1000, 9999))
        pedidos[id_pedido] = {"cliente": correo, "productos": productos_seleccionados}  # Guardamos el pedido
        print(f"Compra realizada con éxito. Número de pedido: {id_pedido}")  # Confirmamos la compra
    else:
        print("No se seleccionaron productos válidos.")  # Si no hay productos válidos, mostramos un error

# Función para hacer seguimiento de un pedido
def seguimiento_pedido():
    print("\n--- Seguimiento de Pedido ---")
    id_pedido = input("Introduce el número de pedido: ")  # Pedimos el número del pedido
    if id_pedido in pedidos:  # Si el pedido existe
        pedido = pedidos[id_pedido]
        cliente = clientes[pedido["cliente"]]  # Buscamos los datos del cliente
        print(f"Cliente: {cliente['nombre']}, Teléfono: {cliente['telefono']}, Correo: {pedido['cliente']}")
        print("Productos del pedido:")  # Mostramos los productos del pedido
        for producto in pedido["productos"]:
            print(f"- {producto['nombre']} ({producto['precio']} €)")
    else:
        print("Pedido no encontrado.")  # Si no existe, mostramos un error

# Menú principal del programa
def menu():
    while True:
        print("\n--- Menú Principal - Tienda Samsung ---")
        print("1. Registrar cliente")
        print("2. Ver clientes")
        print("3. Buscar cliente")
        print("4. Realizar compra")
        print("5. Seguimiento de pedido")
        print("6. Salir")
        
        opcion = input("Elige una opción: ")  # Pedimos una opción al usuario
        if opcion == "1":
            registrar_cliente()  # Llamamos a la función para registrar clientes
        elif opcion == "2":
            ver_clientes()  # Llamamos a la función para ver clientes
        elif opcion == "3":
            buscar_cliente()  # Llamamos a la función para buscar un cliente
        elif opcion == "4":
            realizar_compra()  # Llamamos a la función para realizar una compra
        elif opcion == "5":
            seguimiento_pedido()  # Llamamos a la función para seguimiento de pedidos
        elif opcion == "6":
            print("Saliendo del programa...")  # Mensaje de salida
            break  # Salimos del bucle
        else:
            print("Opción no válida. Inténtalo de nuevo.")  # Si la opción no es válida, mostramos un error

# Ejecución del programa
if __name__ == "__main__":
    menu()  # Llamamos al menú principal