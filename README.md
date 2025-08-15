# Watering Sponge

This Minecraft mod adds special sponges that can automatically place water or lava in a wide area.

## Features

Adds three types of sponges:

- **Watering Sponge**: Places water in the surrounding area.
- **Large Watering Sponge**: Places water in a wider area than the normal Watering Sponge.
- **Lava Sponge**: Places lava in the surrounding area.

The operational range, speed, and other behaviors of each sponge can be customized through server-side configuration.

## Configuration

You can configure the following settings for each sponge type in the server config file (`<world>/serverconfig/wateringsponge-server.toml`):

- `maxTicks`: The maximum number of ticks the sponge will run before stopping.
- `ticksPerBlock`: The number of ticks it takes for the sponge to fill a single block.
- `xzRadius`: The radius in the X and Z directions that the sponge can fill.
- `yHeight`: The height in the Y direction that the sponge can fill.
- `fillBreakable`: Whether the sponge should replace blocks that are breakable by pistons.

## Building

To build the project, run the following command:
```bash
./gradlew build
```
The built jar file will be located in `build/libs`.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

# Watering Sponge (Japanese)

このMinecraft Modは、水や溶岩を広範囲に自動で設置することができる特別なスポンジを追加します。

## 機能

3種類のスポンジを追加します。

- **逆スポンジ**: 周囲に水を設置します。
- **大きな逆スポンジ**: 通常のWatering Spongeよりも広範囲に水を設置します。
- **溶岩スポンジ**: 周囲に溶岩を設置します。

各スポンジの動作範囲や速度などは、サーバーコンフィグからカスタマイズできます。

## 設定

各スポンジについて、以下の項目をサーバー設定ファイル（`<ワールド>/serverconfig/wateringsponge-server.toml`）で設定できます。

- `maxTicks`: スポンジが動作を停止するまでの最大ティック数。
- `ticksPerBlock`: スポンジが1ブロックを埋めるのにかかるティック数。
- `xzRadius`: スポンジが液体を設置するXおよびZ方向の半径。
- `yHeight`: スポンジが液体を設置するY方向の高さ。
- `fillBreakable`: ピストンで破壊可能なブロックを液体で置き換えるかどうか。

## ビルド

プロジェクトをビルドするには:
```bash
./gradlew build
```
ビルドされたjarファイルは `build/libs` に出力されます。

## ライセンス

このプロジェクトはMITライセンスの下で公開されています。詳細は[LICENSE](LICENSE)ファイルをご覧ください。
