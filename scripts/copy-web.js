const fs = require('node:fs');
const path = require('node:path');

const projectRoot = path.resolve(__dirname, '..');
const webDirectory = path.join(projectRoot, 'www');

fs.rmSync(webDirectory, { recursive: true, force: true });
fs.mkdirSync(webDirectory, { recursive: true });
fs.copyFileSync(path.join(projectRoot, 'index.html'), path.join(webDirectory, 'index.html'));