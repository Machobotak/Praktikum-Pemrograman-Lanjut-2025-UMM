import json
import os
import sys

BOOKS_FILE = "books.json"
def load_books():
    if not os.path.exists(BOOKS_FILE):
        return []
    try:
        with open(BOOKS_FILE, "r",encoding="utf-8") as f:
            data = json.load(f)
            if isinstance(data, list):
                return data
            else:
                print("Peringatan: format file tidak sesuai. Menggunakan data kosong.")
                return []
    except json.JSONDecodeError:
        print("Peringatan: file JSON korup atau kosong. Menggunakan data kosong.")
        return []

def save_books(books):
    with open(BOOKS_FILE, "w",encoding="utf-8") as f:
        json.dump(books, f, ensure_ascii=False, indent=4)

def tampilkan_buku(books):
    if not books:
        print("\n(belum ada buku)\n")
        return
    print("\nDaftar buku: ")
    for i,b in enumerate(books,1):
        year = b.get("year") or "-"
        print(f"{i}.{b.get('title','-')} oleh {b.get('author','-')} ({year})")
    print()

def tambah_buku(books):
    print("\nMenambahkan Buku Baru")
    title = input("Masukkan judul buku: ").strip()
    author = input("Masukkan pengarang buku: ").strip()
    year = input("Masukkan tahun buku: ").strip()
    books.append({"title": title, "author": author, "year": year})
    save_books(books)
    print("\nBuku berhasil ditambahkan.\n")

def update_books(books):
    if not books:
        print("(belum ada buku untuk diupdate)\n")
        return
    tampilkan_buku(books)
    idx = input("Masukkan nomor buku yang ingin diupdate: ").strip()
    if not idx.isdigit():
        print("Input tidak valid.\n")
        return
    i = int(idx)-1
    if i < 0 or i >= len(books):
        print("Nomor tidak ada.\n")
        return
    buku = books[i]
    print("\nKosongkan input untuk mempertahankan nilai lama.")
    judul_baru = input(f"Judul baru (kosong = tetap '{buku['title']}'): ").strip()
    pengarang_baru = input(f"Pengarang baru (kosong = tetap '{buku['author']}'): ").strip()
    tahun_baru = input(f"Tahun baru (kosong = tetap '{buku.get('year','-')}'): ").strip()
    if judul_baru :
        buku['title'] = judul_baru
    if pengarang_baru :
        buku['author'] = pengarang_baru
    if tahun_baru :
        buku['year'] = tahun_baru
    save_books(books)
    print("Buku berhasil diupdate")
def hapus_buku(books):
    if not books:
        print("\n(belum ada buku untuk dihapus)\n")
        return
    tampilkan_buku(books)
    idx = input("Masukkan nomor buku yang ingin dihapus: ").strip()
    if not idx.isdigit():
        print("Input tidak valid.\n")
        return
    i = int(idx)-1
    if i < 0 or i >= len(books):
        print("Nomor tidak ada.\n")
        return
    konfirm = input(f"Yakin ingin menghapus '{books[i]['title']}'? (y/n): ").strip().lower()
    if konfirm == "y":
        books.pop(i)
        save_books(books)
        print("Buku berhasil dihapus.\n")
    else:
        print("Batal menghapus.\n")

def main():
    books = load_books()
    while True:
        print("\n--- Menu Perpustakaan ---")
        print("1. Menambahkan Buku")
        print("2. Menampilkan Buku")
        print("3. Mengupdate Buku")
        print("4. Menghapus Buku")
        print("5. Keluar")
        pilihan = int(input("\nMasukkan pilihan menu: "))
        if pilihan == 1:
            tambah_buku(books)
        elif pilihan == 2:
            tampilkan_buku(books)
        elif pilihan == 3:
            update_books(books)
        elif pilihan == 4:
            hapus_buku(books)
        elif pilihan == 5:
            print("Keluar. Sampai jumpa")
            sys.exit(0)
        else:
            print("Pilihan tidak dikenal. silahkan pilih 1-5.")
if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\nKeluar (dari keyboard).")
        sys.exit(0)


