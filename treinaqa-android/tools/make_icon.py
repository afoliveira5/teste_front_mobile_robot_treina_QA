from PIL import Image, ImageDraw, ImageFont
import os

out = r"C:\Users\aparecido.oliveira_s\.cursor\projects\c-Users-aparecido-oliveira-s-Project-quanta\assets\treinaqa-icon-stacked.png"
size = 1024
bg = (244, 246, 248, 255)
ink = (20, 24, 32, 255)
accent = (255, 90, 60, 255)

img = Image.new("RGBA", (size, size), bg)
draw = ImageDraw.Draw(img)

candidates = [
    r"C:\Windows\Fonts\arialbd.ttf",
    r"C:\Windows\Fonts\segoeuib.ttf",
    r"C:\Windows\Fonts\calibrib.ttf",
    r"C:\Windows\Fonts\arial.ttf",
]
font_path = next((p for p in candidates if os.path.exists(p)), None)
print("font=", font_path)

# Adaptive icon safe zone: keep content inside ~66% center
pad = int(size * 0.22)
max_w = size - 2 * pad


def fit_font(text, start):
    size_f = start
    while size_f > 24:
        font = ImageFont.truetype(font_path, size_f) if font_path else ImageFont.load_default()
        bbox = draw.textbbox((0, 0), text, font=font)
        w = bbox[2] - bbox[0]
        if w <= max_w:
            return font, w, bbox[3] - bbox[1], bbox
        size_f -= 4
    font = ImageFont.truetype(font_path, 40) if font_path else ImageFont.load_default()
    bbox = draw.textbbox((0, 0), text, font=font)
    return font, bbox[2] - bbox[0], bbox[3] - bbox[1], bbox


font_treina, w1, h1, b1 = fit_font("treina", 200)
font_qa, w2, h2, b2 = fit_font("QA", 240)

gap = 20
total_h = h1 + gap + h2
y0 = (size - total_h) // 2

x1 = (size - w1) // 2
draw.text((x1 - b1[0], y0 - b1[1]), "treina", font=font_treina, fill=ink)

y2 = y0 + h1 + gap
x2 = (size - w2) // 2
draw.text((x2 - b2[0], y2 - b2[1]), "QA", font=font_qa, fill=accent)

img.save(out, "PNG")
print("saved", out, "treina_w", w1, "qa_w", w2)
