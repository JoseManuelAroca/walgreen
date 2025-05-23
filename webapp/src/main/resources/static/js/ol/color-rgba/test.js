import assert from 'assert'
import rgba from 'color-rgba'

assert.deepEqual(rgba('rgba(1,2,3,.5)'), [1, 2, 3, .5])
assert.deepEqual(rgba('rgba(0,0,0,0)'), [0, 0, 0, 0])
assert.deepEqual(rgba('hsla(0,0,0,1)'), [0, 0, 0, 1])
assert.deepEqual(rgba('rgba(-300,-300,-300,-1)'), [0, 0, 0, 0])

assert.deepEqual(rgba('red'), [255, 0, 0, 1])
assert.deepEqual(rgba('rgb(80, 120, 160)'), [80, 120, 160, 1])
assert.deepEqual(rgba('rgba(80, 120, 160, .5)'), [80, 120, 160, .5])
assert.deepEqual(rgba('rgba(80 120 160 / .5)'), [80, 120, 160, .5])
assert.deepEqual(rgba('hsl(291 80% 50%)'), [198.89999999999995, 25.499999999999993, 229.5, 1])
assert.deepEqual(rgba('hsl(0.8083333333333333turn 80% 50%)'), [198.89999999999995, 25.499999999999993, 229.5, 1])
assert.deepEqual(rgba('hsla(109, 50%, 50%, .75)'), [87.125, 191.25, 63.75, 0.75])
assert.deepEqual(rgba('#f00'), [255, 0, 0, 1])
assert.deepEqual(rgba`#f00`, [255, 0, 0, 1])

assert.deepEqual(rgba('xyz'), [])
// console.log(rgba('hsla(170, 50%, 45%, 1)'))

assert.deepEqual(rgba(0x00ff00), [0, 255, 0, 1])
assert.deepEqual(rgba(new Number(0x00ff00)), [0, 255, 0, 1])

assert.deepEqual(rgba([1, 1, 1, 1]), [1, 1, 1, 1])
assert.deepEqual(rgba(new Uint8Array([255, 255, 255, 255])), [255, 255, 255, 1])
