import os
import shutil
from PIL import Image

SRC_FILE = "gambar/image.jpg"
FOLDER = "gambar"
RESIZED_NAME = "resized.jpg"
COPIED_NAME = "copied_image.jpg"
CONVERTED_NAME = "image_converted.png"

def ensure_dir(path):
    if not os.path.exists(path):
        os.makedirs(path)

def main():
    ensure_dir(FOLDER)

    if not os.path.exists(SRC_FILE):
        print(f"Error: file sumber '{SRC_FILE}' tidak ditemukan. Taruh file di folder yang sama atau ubah SRC_FILE.")
        return

    try:
        img = Image.open(SRC_FILE)
    except Exception as e:
        print("Gagal membuka gambar:", e)
        return

    try:
        try:
            resample = Image.Resampling.LANCZOS
        except AttributeError:
            resample = Image.LANCZOS

        resized = img.resize((200, 200), resample)
        resized_path = os.path.join(FOLDER, RESIZED_NAME)
        resized.save(resized_path, format="JPEG")
        print(f"Gambar berhasil disimpan: {resized_path}")
    except Exception as e:
        print("Gagal meresize/simpan gambar:", e)
        return

    try:
        dst_copy_path = os.path.join(FOLDER, COPIED_NAME)
        shutil.copy2(resized_path, dst_copy_path)
        print(f"Salinan gambar berhasil dibuat dengan nama {dst_copy_path}")
    except Exception as e:
        print("Gagal membuat salinan:", e)
        return

    try:
        img_for_convert = resized
        if img_for_convert.mode in ("RGBA", "LA"):
            png_img = img_for_convert
        else:
            png_img = img_for_convert.convert("RGB")
        converted_path = os.path.join(FOLDER, CONVERTED_NAME)
        png_img.save(converted_path, format="PNG")
        print(f"Format gambar berhasil diubah menjadi PNG dan disimpan dengan nama {converted_path}")
    except Exception as e:
        print("Gagal mengubah format ke PNG:", e)
        return

if __name__ == "__main__":
    main()
